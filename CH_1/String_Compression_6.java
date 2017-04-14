public class String_Compression_6{
	public static String compress(String str){

		StringBuilder sb = new StringBuilder("");

		int count = 1;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i) != str.charAt(i+1)){
				sb.append(str.charAt(i)+"");
				sb.append(count+"");
				count = 0;
			}

			count++;
		}

		sb.append(str.charAt(str.length()-1));
		sb.append(count);

		return sb.toString();

	}
	public static void main(String[] args){
		String x = "aaaabbbbbcccdddee";
		System.out.println(compress(x));
	}
}