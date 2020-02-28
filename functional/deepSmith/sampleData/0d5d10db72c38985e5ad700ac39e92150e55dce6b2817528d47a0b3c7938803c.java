public static void main(String[] a){
  Scanner b=new Scanner(System.in);
  System.out.println("Wil je iets eten?");
  System.out.println("ja");
  System.out.println("nee");
  String c;
  c=b.nextLine();
  if (c.equals("ja")) {
    c=b.nextLine();
    System.out.println("Warm of koud");
  }
 else {
  }
  if (c.equals("nee")) {
    ;
  }
 else {
    System.out.println("Warm of koud?");
    System.out.println("warm");
    System.out.println("koud");
    c=b.nextLine();
    System.out.println("Gezond of ongezond?");
    System.out.println("gezond");
    System.out.println("ongezond");
    c=b.nextLine();
    System.out.println("Met of zonder groenten?");
    System.out.println("met");
    System.out.println("zonder");
    c=b.nextLine();
    System.out.println("Mag het hebben gezwommen?");
    System.out.println("zeker");
    System.out.println("nee");
    c=b.nextLine();
    System.out.println("Alstublieft hier heeft u uw tonijn sashimi dat is dan 7 euro");
  }
  c=b.nextLine();
{
    System.out.println("Wil je dan iets drinken?");
    System.out.println("met prik");
    System.out.println("zonder prik");
    c=b.nextLine();
    System.out.println("Zoet of Neutraal?");
    System.out.println("zoet");
    System.out.println("neutraal");
    c=b.nextLine();
    System.out.println("Gekleurd of helder?");
    System.out.println("gekleurd");
    System.out.println("helder");
    c=b.nextLine();
    System.out.println("Cola of sinas?");
    System.out.println("cola");
    System.out.println("sinas");
    c=b.nextLine();
    System.out.println("Coca Cola of Cola Zero?");
    System.out.println("Coca Cola");
    System.out.println("Cola Zero");
    c=b.nextLine();
    System.out.println("Alstublieft hier heeft u uw Coca Cola dat is dan 2,50 euro");
  }
}
