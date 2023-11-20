package finSysTransaction;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import finSysEnums.EnumTransaction;

public class Transaction {
	
	private double value;
	private EnumTransaction type;
	private LocalDateTime dateTime;
	
	public Transaction(double value, EnumTransaction type, LocalDateTime dateTime) {
		this.value = value;
		this.type = type;
		this.dateTime = dateTime;
	}

	public double getValue() {
		return value;
	}

	public EnumTransaction getType() {
		return type;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
	
	public String getFormattedDateTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return dateTime.format(formatter);
	}
	
	public boolean isValid() {
		return value >= 0;
	}
	
	public double calculateTax() {
		switch (type) {
		case DEPOSIT:
			return 0.02 * value;
		case WITHDRAW:
			return 0.03 * value;
		case TRANSFER:
			return 0.05 * value;
		case PAY_BILL:
			return 0.04 * value;
		default:
			return 0.0;
		}
	}
	
	public String viewDetails() {
		return String.format("Type: %s, Value: %.2f, Date/Hour: %s, Tax: %.2f",
				type, value, getFormattedDateTime(), calculateTax());
	}
	
}
