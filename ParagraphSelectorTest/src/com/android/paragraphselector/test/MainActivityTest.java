package com.android.paragraphselector.test;

import android.test.ActivityInstrumentationTestCase2;
import com.android.paragraphselector.MainActivity;
import android.widget.AbsListView;
import junit.framework.AssertionFailedError;
import com.bitbar.recorder.extensions.ExtSolo;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private ExtSolo solo; // ExtSolo is an extension of Robotium Solo that helps collecting better test execution data during test runs

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		solo = new ExtSolo(getInstrumentation(), getActivity(), this.getClass()
				.getCanonicalName(), getName());
	}

	@Override
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
		solo.tearDown();
		super.tearDown();
	}

	public void testRecorded() throws Exception {
		try {
			solo.waitForActivity("MainActivity");
			solo.sleep(11900);
			assertTrue("Wait for text (text: fixed) failed.",
					solo.waitForText("fixed", 1, 20000));
			solo.clickOnText("fixed");
			solo.sleep(8000);
			assertTrue("Wait for list failed.",
					solo.waitForView(AbsListView.class, 1, 20000, true));
			solo.clickInList(8);
			solo.sleep(1500);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search));
			solo.sleep(1500);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search));
			solo.sleep(1400);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_down) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_down),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_down));
			solo.sleep(1300);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_down) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_down),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_down));
			solo.sleep(1300);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_down) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_down),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_down));
			solo.sleep(1700);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_up) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_up),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_up));
			solo.sleep(1500);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_up) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_up),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_up));
			solo.sleep(1200);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_up) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_up),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_up));
			solo.sleep(1800);
			assertTrue("Wait for text (text: bus) failed.",
					solo.waitForText("bus", 1, 20000));
			solo.clickOnText("bus");
			solo.sleep(21800);
			assertTrue("Wait for list failed.",
					solo.waitForView(AbsListView.class, 1, 20000, true));
			solo.clickInList(3);
			solo.sleep(1800);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search));
			solo.sleep(2500);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_down) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_down),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_down));
			solo.sleep(1500);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_down) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_down),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_down));
			solo.sleep(2000);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_down) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_down),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_down));
			solo.sleep(2500);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_up) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_up),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_up));
			solo.sleep(1300);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_up) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_up),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_up));
			solo.sleep(1300);
			assertTrue(
					"Wait for image button (id: com.android.paragraphselector.R.id.search_up) failed.",
					solo.waitForView(
							solo.findViewById(com.android.paragraphselector.R.id.search_up),
							20000, true));
			solo.clickOnView(solo
					.findViewById(com.android.paragraphselector.R.id.search_up));
		} catch (AssertionFailedError e) {
			solo.fail(
					"com.android.paragraphselector.test.MainActivityTest.testRecorded_scr_fail",
					e);
			throw e;
		} catch (Exception e) {
			solo.fail(
					"com.android.paragraphselector.test.MainActivityTest.testRecorded_scr_fail",
					e);
			throw e;
		}
	}

}
