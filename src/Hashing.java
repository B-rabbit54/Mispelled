
public class Hashing {
	private static int hash(String str)
	{
		int hash = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			hash+= (str.charAt(i) * Math.pow(10, str.length() - i));
		}
		return hash;
	}
	
	public static void main(String[] args)
	{
		System.out.println(hash("josh"));
		System.out.println(hash("cat"));
		System.out.println(hash("brian"));
		System.out.println(hash("brian"));
		System.out.println(hash("brianna"));
		System.out.println(hash("bannana"));
	}

}
