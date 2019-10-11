package impl;

public interface PasswortGenerator {

	public static final char[] VOCALS = new char[] {'a','e','i','o','u'};
	public static final char[] CONSONANTS = new char[] {'b','c','d','f','g','h',
			'j','k','l','m','n','p','q','q','r','s','t','v','w','x','y','z'};
	public static final int length = 10;  

	public static PasswortGenerator standard = new PasswortGenerator() {
		
		@Override
		public String create() {
			int i = 0;
			StringBuilder result = new StringBuilder(); 
			
			while (i++ < length) {
				if (i % 2 == 0) {
					result.append(VOCALS[(int)(Math.random() * VOCALS.length)]);
				} else {
					result.append(CONSONANTS[(int)(Math.random() * CONSONANTS.length)]);
				}
				
			}
			return result.toString();
		}
	};
	
	public static void main(String[] args) {
		System.out.println(standard.create());
	}
	
	public String create();
	
	
}
