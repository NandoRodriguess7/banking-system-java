package finSysUtil;

public class CPFUtil {
	
	public static boolean validateCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		
		if (cpf.length() != 11 || allDigitsEqual(cpf)) {
			return false;
		}
		
		int[] digits = getDigits(cpf);
		
		if (!validateCheckDigit(cpf, digits, 9) || !validateCheckDigit(cpf, digits, 10)){
			return false;
		}
		
		return true;
	}
	
	private static int[] getDigits(String cpf) {
		int[] digits = new int[11];
		for (int i=0; i<11; i++) {
			digits[i] = Character.getNumericValue(cpf.charAt(i));
		}
		return digits;
	}
	
	private static boolean validateCheckDigit(String cpf, int[] digits, int position) {
		int sum = 0;
		for (int i=0; i<position; i++) {
			sum += digits[i] * (position + 1 - i);
		}
		
		int rest = sum % 11;
		int verifyingDigit = (rest < 2) ? 0 : (11 - rest);
		
		return verifyingDigit == digits[position];
	}

	private static boolean allDigitsEqual(String cpf) {
		return cpf.matches("(\\d)\\1*");
	}
	
	public static String formatCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		return String.format("%s.%s.%s-%s",
				cpf.substring(0, 3),
				cpf.substring(3, 6),
				cpf.substring(6, 9),
				cpf.substring(9));
	}
	
}
