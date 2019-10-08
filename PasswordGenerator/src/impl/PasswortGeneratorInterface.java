package impl;

public interface PasswortGeneratorInterface {

	public static final String[] VOCALS = new String[] {"a","e","i","o","u"};
	public static final String[] CONSONANTS = new String[] {"b","c","d","f","g","h",
			"j","k","l","m","n","p","q","q","r","s","t","v","w","x","y","z"};
	public static final int length = 10;  

	public static PasswortGeneratorInterface instance = new PasswortGeneratorInterface() {
		
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
		System.out.println(instance.create());
	}
	
	public String create();
	
	
}
