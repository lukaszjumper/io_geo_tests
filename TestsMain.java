package maly_geograf_tests;


public class TestsMain {
	private static Site site;

	public static void main(String[] args) {
	       System.setProperty("webdriver.chrome.driver", "/home/lukasz/Dokumenty/nauka/studia/inżynieria/drivers/chromedriver");
	        
	       site = new Site();
	       site.open();
	       
	       noCoordinatesTest();
	       zoomTest();
	       pointTest();
	       coordinatesTest();
	       hipsoTest();
	       test3D();
	       
	       site.close();
	}
	
	static void noCoordinatesTest() {
		System.out.print("EmptyCoordinatesTest: ");
		
		try {
			site.clickShowCoordinates();
			Thread.sleep(200);
			if (site.modalTitle().compareTo("Współrzędne") != 0) {
				throw new Exception();
			}
			site.closeModal();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
		}
	}
	
	static void zoomTest() {
		System.out.print("ZoomTest: ");
		site.refresh();
		try {
			Thread.sleep(100);
			site.zoomIn();
			site.zoomIn();
			site.zoomIn();
			site.zoomOut();
			Thread.sleep(100);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
		}
	}
	
	static void pointTest() {
		site.refresh();
		try {
			Thread.sleep(100);
			site.someArea();
			System.out.print("pointTest: ");
			Thread.sleep(100);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
		}
	}
	
	static void coordinatesTest() {
		site.refresh();
		try {
			Thread.sleep(100);
			site.someArea();
			System.out.print("coordinatesTest: ");
			Thread.sleep(100);
			site.clickShowCoordinates();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
		}
	}
	
	static void hipsoTest() {
		site.refresh();
		try {
			Thread.sleep(100);
			site.someArea();
			System.out.print("hipsometricTest: ");
			Thread.sleep(1000);
			site.clickHipso();
			Thread.sleep(20000);
			if (!site.newTab()) {
				throw new Exception();
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
		}
	}
	
	static void test3D() {
		site.refresh();
		try {
			Thread.sleep(100);
			site.someArea();
			System.out.print("3DTest: ");
			Thread.sleep(1000);
			site.click3d();
			Thread.sleep(20000);
			if (!site.newTab()) {
				throw new Exception();
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println("FAIL");
		}
	}
}
