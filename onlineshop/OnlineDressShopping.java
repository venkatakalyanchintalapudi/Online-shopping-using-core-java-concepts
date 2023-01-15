
import products.items;
import java.util.*;
import java.io.*;
class size
{
		Scanner in=new Scanner(System.in);
		int y;
		public String kidsize()
		{	
			System.out.println("Size Chart:");
			System.out.println("\t|1.0M-3M\t2.3M-6M\t\t3.6M-9M\t\t4.9M-12M\t|\n\t|5.12M-18M\t6.18M-24M\t7.2Y-4Y\t\t8.4Y-6Y\t\t|\n\t|9.6Y-8Y\t10.8Y-10Y\t11.10Y-12Y\t12.12Y-14Y\t|");
			y=in.nextInt();
			String sz[]={"0M-3M","3M-6M","6M-9M","9M-12M","12M-18M","18M-24M","2Y-4Y","4Y-6Y","6Y-8Y","8Y-10Y","10Y-12Y","12Y-14Y"};
			while(y<1 || y>13)
			{
				System.out.println("Enter valid size");
				y=in.nextInt();
			}
			return sz[y-1];
		}
		public String shirtsize()
		{
			System.out.println("Size Chart:");
			System.out.println("\t|1.XS\t2.S\t3.M\t4.L\t|\n\t|5.XL\t6.XXL\t7.3XL\t8.4XL\t|");
			y=in.nextInt();
			String sz[]={"XS","S","M","L","XL","XXL","3XL","4XL"};
			while(y<1 || y>8)
			{
				System.out.println("Enter valid size");
				y=in.nextInt();
			}
			return sz[y-1];
		}
		public int pantsize()
		{
			System.out.println("Size Chart:");
			System.out.println("\t|1.24\t2.26\t3.28\t4.30|\n\t|5.32\t6.34\t7.36L\t8.40|\n\t|9.42\t10.44\t11.46\t12.48|");
			y=in.nextInt();
			int sz[]={24,26,28,30,32,34,36,38,40,42,44,46,48};
			while(y<1 || y>12)
			{
				System.out.println("Enter valid size");
				y=in.nextInt();
			}
			return sz[y-1];
		}
}
class ColourException extends Exception
{
	ColourException(String str)
	{
		super(str);
	}	
}
class colour
{	
	Scanner sc=new Scanner(System.in);
	String s;
	int i;
	public String shirtscolour()
	{
		System.out.println("Select the colour:\n\tRed,Yellow,Green,White,Black,Blue");
		String s[]={"Red","Yellow","Green","White","Black","Blue"};
		i=sc.nextInt();
		try
		{
			if (i>5)
				throw new ColourException("Select valid Colour");
		}
		catch(ColourException e)
		{
			System.out.println(e);
		}
		return s[i-1];
	}
	public String pantcolour()
	{	
		System.out.println("Select the colour:\n\tBlue,Black,NavyBlue,Grey,Brown");
		String s[]={"Blue","Black","NavyBlue","Grey","Brown"};
		i=sc.nextInt();
		try
		{
			if (i>4)
				throw new ColourException("Select valid Colour");
		}
		catch(ColourException e)
		{
			System.out.println(e);
		}
		return s[i-1];
	}
	public String ethnicw()
	{
		System.out.println("Select the colour:\n\tRed,Pink,Blue,Black,NavyBlue,Grey");
		String s[]={"Red","Pink","Blue","Black","NavyBlue","Grey"};
		i=sc.nextInt();
		try
		{
			if (i>6)
				throw new ColourException("Select valid Colour");
		}
		catch(ColourException e)
		{
			System.out.println(e);
		}
		return s[i-1];
	}
	public String common()
	{
		System.out.println("Select the colour:\n\tRed,Yellow,Beige,Blue,Black,Cream,Grey,Navy blue,Orange");
		String s[]={"Red","Yellow","Beige","Blue","Black","Cream","Grey","Navy blue","Orange"};
		i=sc.nextInt();
		try
		{
			if (i>8)
				throw new ColourException("Select valid Colour");
		}
		catch(ColourException e)
		{
			System.out.println(e);
		}
		return s[i-1];
	}	
}
interface Disc
{
	public double dis(double d,double p);
}
class Bill 
{	
	void Add(String s)throws IOException
	{	
		try
		{
			BufferedWriter bw=new BufferedWriter(new FileWriter("Bill.txt",true));
			bw.write(s);
			bw.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
class Billdis implements Runnable
{	
	String name;
	Thread t;
	Billdis()
	{	
		t=new Thread(this,"Display Bill");
		t.start();
	}
	public void run()
	{
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("Bill.txt"));
			String s=br.readLine();
			while(s!=null)
			{
				System.out.println(s);
				s=br.readLine();
				Thread.sleep(10);	
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
class kids 
{
	Scanner si=new Scanner(System.in);
	int c;
	public void kidswear()throws IOException
	{
		System.out.println("Choose\n\t1.Boys clothing\n\t2.Girls clothing");
		c=si.nextInt();
		switch(c)
		{
			case 1:
				kids.boyswear b=new Boys();
				b.boysdress();
				break;
			case 2:
				kids.girlswear g=new Girls();
				g.girlsdress();
				break;
			default:
				System.out.println("Enter the valid choice");
				break;
		}	
	}
	public interface boyswear
	{	
		public void boysdress();
		public double tshirts();
		public double shirts();
		public double pants();
		public double ethnic();
		public double nightwear();
		public double innerwear();
		public String dresssize();
	}
	public interface girlswear
	{	
		public void girlsdress();
		public double dresses();
		public double tops();
		public double skirts();
		public double ethnic();
		public double jeans();
		public double nightwear();
		public double innerwear();
		public String dresssize();
	}
}

class Boys extends Bill implements kids.boyswear 
{
	Scanner in=new Scanner(System.in);
	size sz=new size();
	colour cr=new colour();
	items it=new items();
	int c,choice;
	String item,cost,colour,size;
	double x;
	public void boysdress()
	{	
		try
		{
			final double rate=5.0;
			System.out.println("Type of clothes:\n\t1.T-shirts\n\t2.Shirts\n\t3.Jeans and Trousers\n\t4.Ethnic wear\n\t5.Night wear\n\t6.Innerwear");
			choice=in.nextInt();
			while(choice<1 || choice>6)
			{
				System.out.println("Enter valid choice");
				choice=in.nextInt();
			}
			if(choice==1)
				x=tshirts();
			else if(choice ==2)
				x=shirts();
			else if(choice==3)
				x=pants();
			else if(choice==4)
				x=ethnic();
			else if(choice==5)
				x=nightwear(); 
			else 
				x=innerwear();
			Disc di=(r,pric)->
			{
				return pric - (r*pric*0.01);
			};
			Add("Item : "+item+"\n");
			Add("Price : "+cost+"\n");
			Add("Colour : "+colour+"\n");
			Add("Size : "+dresssize()+"\n");
			Add("Discount : "+rate+"%\nNew Price : "+di.dis(rate,x)+"\n\n");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public double tshirts()
	{
		System.out.println("T-shirts :\n\t1.Printed T-shirts\n\t2.Plane T-shirts\n\t3.Cotton T-shirts\n\t4.Combo sets(2-4 T-shirts)");
		c=in.nextInt();
		double d[]={400.00,300.00,500.00,600.00};
		item=it.TS(c);
		cost=Double.toString(d[c-1]);
		colour=cr.shirtscolour();
		return d[c-1];
	}
	public double shirts()
	{
		System.out.println("Shirts :\n\t1.Casual Shirts\n\t2.Formal Shirts\n\t3.Combo sets(2-4 Shirts)");
		c=in.nextInt();
		double d[]={250.00,350.00,600.00};
		item=it.SH(c);
		cost=Double.toString(d[c-1]);
		colour=cr.shirtscolour();
		return d[c-1];
	}
	public double pants()
	{
		System.out.println("Jeans and Trousers :\n\t1.Plane Jeans\n\t2.Fit Jeans\n\t3.Torn Jeans\n\t4.Fit Joggers\n\t5.Trousers\n\t6.Combo sets(2-4 Jeans)");
		c=in.nextInt();
		double d[]={250.00,350.00,400.00,330.00,500.00,700.00};
		item=it.JT(c);
		cost=Double.toString(d[c-1]);
		colour=cr.pantcolour();
		return d[c-1];
	}
	public double ethnic()
	{
		System.out.println("Occasion wear :\n\t1.Kurtha With Patiala\n\t2.Sherwani\n\t3.Four-piece Suit\n\t4.Five-piece Suit\n\t5.Nehru Jacket set");
		c=in.nextInt();
		double d[]={600.00,750.00,800.00,1000.00,1600.00};
		item=it.BEW(c);
		cost=Double.toString(d[c-1]);
		colour=cr.ethnicw();
		return d[c-1];
	}
	public double nightwear()
	{
		System.out.println("Night Wear :\n\t1.T-shirt & Shorts\n\t2.Printed Night Suit\n\t3.Plane Cotton Night Suit\n\t4.Printed Cotton Night Suit");
		c=in.nextInt();
		double d[]={250.00,350.00,450.00,500.00};
		item=it.BNW(c);
		cost=Double.toString(d[c-1]);
		colour=cr.common();
		return d[c-1];
	}
	public double innerwear()
	{
		System.out.println("Inner Wear : \n\t1.Inner Wear Vests\n\t2.Briefs\n\t3.Boxers");
		c=in.nextInt();
		double d[]={1200.00,100.00,150.00};
		String s[]={"Inner Wear vests","Briefs","Boxers"};
		item=s[c-1];
		cost=Double.toString(d[c-1]);
		colour=cr.common();
		return d[c-1];
	}
	public String dresssize()
	{	
		return sz.kidsize();
	}
}
class Girls extends Bill implements kids.girlswear
{
	Scanner in=new Scanner(System.in);
	size sz=new size();
	colour cr=new colour();
	items it=new items();
	int c,choice;
	String item,cost,colour,size;
	double x;
	public void girlsdress()
	{	
		final double rate=8.0;
		try
		{
			System.out.println("Type of clothes:\n\t1.Dresses,Frocks & Jumpsuits\n\t2.Tops,T-shirts & Shirts\n\t3.Skirts & Shorts\n\t4.Jeans,Trousers & Capris\n\t5.Ethnic Wear\n\t6.Night Wear\n\t7.Inner Wear");
			choice=in.nextInt();
			while(choice<1 || choice>7)
			{
				System.out.println("Enter valid choice");
				choice=in.nextInt();
			}
			if(choice==1)
				x=dresses();
			else if(choice ==2)
				x=tops();
			else if(choice==3)
				x=skirts();
			else if(choice==4)
				x=jeans();
			else if(choice==5)
				x=ethnic();			
			else if(choice==6)
				x=nightwear();
			else
				x=innerwear();
			Disc di=(r,pric)->
			{
				return (pric - (r*pric*0.01));
			};
			Add("Item : "+item+"\n");
			Add("Price : "+cost+"\n");
			Add("Colour : "+colour+"\n");
			Add("Size : "+dresssize()+"\n");
			Add("Discount : "+rate+"%\nNew Price : "+di.dis(rate,x)+"\n\n");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public double dresses()
	{
		System.out.println("Dresses,Frocks & Jumpsuits:\n\t1.Fit & Flare Dress\n\t2.Printed Fit & Flare Dress\n\t3.Floral Net Dress\n\t4.A-line Dress\n\t5.Basic Jumpsuit\n\t6.Printed Playsuit");
		c=in.nextInt();
		double d[]={1000.00,1350.00,1200.00,900.00,800.00,980.00};
		item=it.DFT(c);
		cost=Double.toString(d[c-1]);
		colour=cr.common();
		return d[c-1];
	}
	public double tops()
	{
		System.out.println("Tops,T-shirts & Shirts:\n\t1.Printed Tops\n\t2.Ruffle Tops\n\t3.Cotton Tops\n\t4.V-neck Cotton T-shirt\n\t5.Printed Cotton T-shirt\n\t6.Casual Shirt\n\t7.Printed Shirt");
		c=in.nextInt();
		double d[]={350.00,400.00,450.00,600.00,750.00,650.00,375.00};	
		item=it.TTS(c);
		cost=Double.toString(d[c-1]);
		colour=cr.shirtscolour();
		return d[c-1];
	}
	public double skirts()
	{
		System.out.println("Skirts & Shorts:\n\t1.A-Line Skirt\n\t2.Floral Printed Skirt\n\t3.Tulle Skirt\n\t4.Regular Shorts\n\t5.Denim Shorts\n\t6.Combo(2-4 Cotton Shorts)");
		c=in.nextInt();
		double d[]={250.00,350.00,600.00,700.00,500.00,490.00};
		item=it.SS(c);
		cost=Double.toString(d[c-1]);
		colour=cr.pantcolour();
		return d[c-1];
	}
	public double jeans()
	{
		System.out.println("Jeans,Trousers & Capris:\n\t1.Embroidered Jeans\n\t2.Skinny Fit Jeans\n\t3.Regular Fit Capris\n\t4.Fit Trousers\n\t5.Combo(2-4 Jeans)");
		c=in.nextInt();
		double d[]={250.00,350.00,600.00,450.00,650.00};	
		item=it.JTC(c);
		cost=Double.toString(d[c-1]);
		colour=cr.pantcolour();
		return d[c-1];
	}
	public double ethnic()
	{
		System.out.println("Ethnic Wear:\n\t1.Kurtha Sets\n\t2.Kurtha with Sharara & Dupatta\n\t3.Kurti with Dhoti Pants\n\t4.Kurti with Palazoos\n\t5.Lehenga\n\t6.Lehenga with Choli");
		c=in.nextInt();
		double d[]={550.00,850.00,600.00,400.00,900.00,1200.00};
		item=it.GEW(c);
		cost=Double.toString(d[c-1]);
		colour=cr.ethnicw();
		return d[c-1];		
	}
	public double nightwear()
	{
		System.out.println("Night Wear:\n\t1.Night Suit\n\t2.Night Dress\n\t3.Lounge Tshirts\n\t4.Lounge T-shirts");
		c=in.nextInt();
		double d[]={250.00,350.00,600.00,450.00};
		item=it.GNW(c);
		cost=Double.toString(d[c-1]);
		colour=cr.common();	
		return d[c-1];
	}
	public double innerwear()
	{
		System.out.println("Inner Wear : \n\t1.Inner Wear Vests\n\t2.Briefs");
		c=in.nextInt();
		double d[]={120.00,150.00,100.00};
		String s[]={"Inner Wear vests","Briefs"};
		item=s[c-1];
		cost=Double.toString(d[c-1]);
		colour=cr.common();
		return d[c-1];
	}
	public String dresssize()
	{	
		return sz.kidsize();
	}
}
class Seasonwear extends Bill
{	
	Scanner sc=new Scanner(System.in);
	int c,i;
	colour cr=new colour();
	size sz=new size();
	final double rate=7.0;
	void seasonalwear()
	{
		System.out.println("Choose:\n\t1.kids\n\t2.Mens\n\t3.Womens");
		i =sc.nextInt();
		System.out.println("Winter/Rainy Season Wear:\n\t1.Sweaters\n\t2.Rain coats\n\t3.Puffer Jacket\n\t4.Hoodie")	;
		String s[]={"Sweaters","Rain Coat","Puffer Jacket","Hoodie"};
		c=sc.nextInt();
		double d[]={650.00,550.00,600.00,700.00};
		try
		{	
			Add("Item : "+s[c-1]+"\n");
			Add("Colour : "+cr.common()+"\n");
			Add("Price : "+Double.toString(d[c-1])+"\n");
			if(i==1)
				Add("Size : "+sz.kidsize()+"\n");
			else if(i==2)
				Add("Size : "+sz.shirtsize()+"\n");
			else
				Add("Size : "+sz.shirtsize()+"\n");
			Disc di=(r,pric)->
			{
				return (pric - (r*pric*0.01));
			};
			Add("Discount : "+rate+"%\nNew Price : "+di.dis(rate,d[c-1])+"\n\n");
		} 
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
class Mens extends Boys
{	
	void menswear()
	{
		boysdress();
	}
	public String dresssize()
	{	
		if (choice==3)
			return String.valueOf(sz.pantsize());
		else
			return sz.shirtsize();
	}
}
class Womens extends Girls
{	
	void womenswear()throws IOException
	{
		girlsdress();
	}
	public String dresssize()
	{	
		if (choice==4)
			return String.valueOf(sz.pantsize());
		else
			return sz.shirtsize();
	}
}
class OnlineDressShopping
{
	public static void main(String args[])
	{   
	  try
	  {
	      Scanner sc=new Scanner(System.in);
	      int ic=0,k=1;
	      System.out.println("\n~~Welcome to Online Dress Shopping~~");
	      System.out.println("~~Stay Home and Shop Online~~");
	      String s;
	      System.out.println("Do you want to Start Shopping:Yes or No");
	       s=sc.nextLine();
	      while(!s.equals("No") && !s.equals("no"))
	      {	
		if(s.equals("Yes") || s.equals("yes"))
	            {
		  System.out.println("CHOOSE:\n\t1.Kids\n\t2.Men\n\t3.Women\n\t4.Winter/Rainy Season wear");
		  System.out.println("Enter your choice:");
		  int ch=sc.nextInt();
		  sc.nextLine();
		  switch(ch)
		  { 
			case 1:
				kids ki=new kids();
				ki.kidswear();
				break;
			case 2:
				Mens me=new Mens();
				me.menswear();
				break;
			case 3:
				Womens we=new Womens();
				we.womenswear();
				break;
				
			case 4:
				Seasonwear se=new Seasonwear();
				se.seasonalwear();
				break;
			default:
				System.out.println("Enter valid choice");
				break;
		  }
		 System.out.println("Continue Shopping:Yes or No");
		 s=sc.nextLine();
	         }
	       }
	  }
	  catch(Exception e)
	  {
	   	e.printStackTrace();	
	  }
	  finally
	  {
		System.out.println("\nShopping completed:\nBill : \n");
		new Billdis();
	   }	  	
	}
}