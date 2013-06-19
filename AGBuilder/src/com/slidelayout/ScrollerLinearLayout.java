package com.slidelayout;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Scroller;

public class ScrollerLinearLayout extends LinearLayout {

	private static Context context;
	private static Scroller scroller;
	@SuppressWarnings("unused")
	private static float density;
	private static int scrollerWidth;
	private boolean isOpen = true;
	

	@SuppressWarnings("static-access")
	public ScrollerLinearLayout(Context context) {
		super(context);
		this.context = context;
		scrollerWidth= 250;
		init();
	}

	@SuppressWarnings("static-access")
	public ScrollerLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}

	@SuppressWarnings({ "unused", "deprecation" })
	public static void init() {
		scroller = new Scroller(context);

		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display disp = wm.getDefaultDisplay();
		int screenWidth = disp.getWidth();

		DisplayMetrics metrics = new DisplayMetrics();
		((Activity) context).getWindowManager().getDefaultDisplay()
				.getMetrics(metrics);
		density = metrics.density;

		scrollerWidth = 250;
		
	}

	public void scroll(ListView listView) {
	
		animationStart();
		if (isOpen == true) {
			listView.setEnabled(true);
		} else
			listView.setEnabled(false);
	}


	public void computeScroll() {
		if (scroller.computeScrollOffset()) {

			scrollTo(scroller.getCurrX(), scroller.getCurrY());
			postInvalidate();
		}
	}

	private void animationStart() {
		if (scroller.getCurrX() < 0) {
			isOpen = false;
			scroller.startScroll(scroller.getCurrX(), scroller.getCurrY(), -1
					* scroller.getCurrX(), 0, 500);
		} else {
			isOpen = true;
			scroller.startScroll(scroller.getCurrX(), scroller.getCurrY(),
					-scrollerWidth, 0, 500);

		}
		invalidate();
	}
	
	public boolean isOpen(){
		return isOpen;
	}
	
	public int getScrollerWidth (){
		return scrollerWidth;
	}


}