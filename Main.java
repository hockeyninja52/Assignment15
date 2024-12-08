package wk15d1;

public class Main {

	public static void main(String[] args) {
		HashTable hash = new HashTable(10);
		hash.Insert(0,"Coding");
		hash.Insert(1,"III");
		hash.Insert(2,"Is");
		hash.Insert(3,"very");
		hash.Insert(4, "fun");
		hash.Insert(5,"but");
		hash.Insert(6,"very");
		hash.Insert(7,"challenging");
		hash.Insert(8,null);
		hash.Insert(9,null);
		/*
		hash.Insert(10,"1");
		hash.Insert(11,"2");
		hash.Insert(12,"3");
		hash.Insert(13,"4");
		hash.Insert(14,"5");
		hash.Insert(15,"6");
		hash.Insert(16,"6");
		hash.Insert(17,"7");
		hash.Insert(18,"8");
		hash.Insert(19,"9");
		*/
		System.out.println(hash.Search(0));
		System.out.println(hash.Search(5));
		//System.out.println(hash.Search(7));
		//hash.Display();
	}
}
