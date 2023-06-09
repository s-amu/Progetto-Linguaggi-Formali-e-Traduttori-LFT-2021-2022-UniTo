public class NotazioneScientifica{
	public static boolean scan(String s){
		int state = 0;
		int i = 0;
		
		while (state >= 0 && i < s.length()){
			final char ch = s.charAt(i++);
			
			switch (state){
			case 0:
				if (ch == '+' || ch == '-' || ch == '0')
					state = 1;
				else if (ch <= '9' && ch >= '1')
					state = 2;
				else if (ch == '.')
					state = 3;
				else
					state = -1;
				break;
				
			case 1:
				if (ch <= '9' && ch >= '1')
					state = 2;
				else if (ch == '.')
					state = 3;
				else
					state = -1;
				break;
				
			case 2:
				if (ch == 'e')
					state = 5;
				else if (ch == '.')
					state = 3;
				else if (ch <= '9' && ch >= '0')
					state = 2;
				else
					state = -1;
				break;
				
			case 3:
				if (ch <= '9' && ch >= '0')
					state = 4;
				else if (ch == 'e')
					state = 5;
				else
					state = -1;
				break;
				
			case 4:
				if (ch <= '9' && ch >= '0')
					state = 4;
				else if (ch == 'e')
					state = 5;
				else
					state = -1;
				break;
				
			case 5:
				if (ch == '+' || ch == '-')
					state = 6;
				else if (ch <= '9' && ch >= '0')
					state = 7;
				else
					state = -1;
				break;
				
			case 6:
				if (ch <= '9' && ch >= '0')
					state = 7;
				else
					state = -1;
				break;
				
			case 7:
				if (ch <= '9' && ch >= '0')
					state = 7;
				else if (ch == '.')
					state = 8;
				else
					state = -1;
				break;
				
			case 8:
				if (ch <= '9' && ch >= '0')
					state = 7;
				else
					state = -1;
				break;
			}
		}
		return state == 2 || state == 4 || state == 7;
	}

    public static void main(String[] args){
	System.out.println(scan(args[0]) ? "OK" : "NOPE");
    }
}