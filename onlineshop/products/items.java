package products;
import java.util.*;
public class items
{	
	public String TS(int i)
	{
		HashMap<Integer,String> ts=new HashMap<Integer,String>();
		ts.put(1,"Printed T-shirts");
		ts.put(2,"Plane T-shirts");
		ts.put(3,"Cotton T-shirts");
		ts.put(4,"Combo sets(2-4 T-shirts Combo)");
		return ts.get(i);
	}
	public String SH(int i)
	{
		HashMap<Integer,String> sh=new HashMap<Integer,String>();
		sh.put(1,"Casual Shirts");
		sh.put(2,"Formal Shirts");
		sh.put(3,"Combo sets(2-4 Shirts Combo)");
		return sh.get(i);
	}
	public String JT(int i)
	{
		LinkedList<String> jt=new LinkedList<String>();
		jt.add("Fit Jeans");
		jt.add("Torn Jeans");
		jt.add("Fit Joggers");
		jt.addLast("Combo sets(2-4 Jeans)");
		jt.addFirst("Plane Jeans");
		jt.add(4,"Trousers");
		return jt.get(i-1);
	}
	public String BEW(int i)
	{
		ArrayList<String> bew=new ArrayList<String>();
		bew.add("Kurtha With Patiala");
		bew.add("Sherwani");
		bew.add("Four-piece Suit");
		bew.add("Five-piece Suit");
		bew.add("Nehru Jacket set");
		return bew.get(i-1);
	}
	public String BNW(int i)
	{
		TreeMap<Integer,String> nw=new TreeMap<Integer,String>();
		nw.put(3,"Plane Cotton Night Suit");
		nw.put(1,"T-shirt & Shorts");
		nw.put(4,"Printed Cotton Night Suit");
		nw.put(2,"Printed Night Suit");
		return nw.get(i);
	}
	public String DFT(int i)
	{
		HashMap<Integer,String> df=new HashMap<Integer,String>();
		df.put(1,"Fit & Flare Dress");
		df.put(2,"Printed Fit & Flare Dress");
		df.put(3,"Floral Net Dress");
		df.put(4,"A-line Dress");
		df.put(5,"Basic Jumpsuit");
		df.put(6,"Printed Playsuit");
		return df.get(i);
	}
	public String TTS(int i)
	{
		ArrayList<String> tts=new ArrayList<String>();
		tts.add("Printed Tops");
		tts.add("Ruffle Tops");
		tts.add("Cotton Tops");
		tts.add("V-neck Cotton T-shirt");
		tts.add("Printed Cotton T-shirt");
		tts.add("Casual Shirt");
		tts.add("Printed Shirt");
		return tts.get(i-1);
	}
	public String SS(int i)
	{
		HashMap<Integer,String> ss=new HashMap<Integer,String>();
		ss.put(1,"A-Line Skirt");
		ss.put(2,"Floral Printed Skirt");
		ss.put(3,"Tulle Skirt");
		ss.put(4,"Regular Shorts");
		ss.put(5,"Denim Shorts");
		ss.put(6,"Combo(2-4 Cotton Shorts)");
		return ss.get(i);
	}
	public String JTC(int i)
	{
		LinkedList<String> jtc=new LinkedList<String>();
		jtc.add("Skinny Fit Jeans");
		jtc.add("Regular Fit Capris");
		jtc.add("Fit Trousers");
		jtc.addLast("Combo sets(2-4 Jeans)");
		jtc.addFirst("Embroidered Jeans");
		return jtc.get(i-1);
	}
	
	public String GEW(int i)
	{
		TreeMap<Integer,String> gew=new TreeMap<Integer,String>();
		gew.put(3,"Kurti with Dhoti Pant");
		gew.put(1,"Kurtha Sets");
		gew.put(4,"Kurti with Palazoos");
		gew.put(2,"Kurtha with Sharara & Dupatta"); 
		gew.put(6,"Lehenga with Choli");
		gew.put(5,"Lehenga");
		return gew.get(i);
	}
	public String GNW(int i)
	{
		ArrayList<String> gnw=new ArrayList<String>();
		gnw.add("Night Suit");
		gnw.add("Night Dress");
		gnw.add("Lounge Tshirts");
		gnw.add("Lounge T-shirts");
		return gnw.get(i-1);
	}
}