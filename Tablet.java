package lamda_functional_interface;

import java.time.LocalDate;

public class Tablet {
	
	String tablet_name;
	String manufacturer;
	String manufacture_date;
	LocalDate expiry_date;
	
	public Tablet() {
		super();
	}

	public Tablet(String tablet_name, String manufacturer, String manufacture_date, LocalDate expiry_date) {
		super();
		this.tablet_name = tablet_name;
		this.manufacturer = manufacturer;
		this.manufacture_date = manufacture_date;
		this.expiry_date = expiry_date;
	}

	public String getTablet_name() {
		return tablet_name;
	}

	public void setTablet_name(String tablet_name) {
		this.tablet_name = tablet_name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacture_date() {
		return manufacture_date;
	}

	public void setManufacture_date(String manufacture_date) {
		this.manufacture_date = manufacture_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

	@Override
	public String toString() {
		return "Tablet [tablet_name=" + tablet_name + ", manufacturer=" + manufacturer + ", manufacture_date="
				+ manufacture_date + ", expiry_date=" + expiry_date + "]";
	}
	
	
	

}
