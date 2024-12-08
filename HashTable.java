package wk15d1;

//this is a hash table resolved using linear probe
public class HashTable {
	public int Size;
	public Item [] Table;
	
	public HashTable(int Size) {
		this.Size = Size;
		this.Table = new Item[Size];
		//we need to give the init array each item
		//empty-since-start flag
		//empty-after-removal 
		//common flag
		
		for(int i = 0; i < this.Size; i++) {
			this.Table[i] = new Item();
		}
	}
	
	public int Hashing(int Key) {
		return Key % this.Size;
	}
	
	public boolean Insert(int key, String value) {
		//return true when success
		//return false when the table is full or there is nothing to update
		int index = Hashing(key);
		Item toCheck = this.Table[index];
		int count = 0;
		while(count < this.Size) {
			if(toCheck.Flag == ItemFlag.empty_since_start || toCheck.Flag == ItemFlag.empty_after_removal) {
				Item newItem = new Item(key, value);
				this.Table[index] = newItem;
				return true;
			}else if(toCheck.Key == key) {
				toCheck.Value = value; //update
				return true;
			}else {
				index++;
				count++;
				if(index == this.Size) {
					index = 0;
				}
				toCheck = this.Table[index];
			}
		}
		return false;
	}
	
	public Item Search(int key) {
		//do yourself
		//search one by one
		//jump over flag empty-after-rm
		//stop when find by the key or met empty-since-start
		int count = 0;
		int index = Hashing(key);
		Item checker = this.Table[index];
		while(count < this.Size) { //maybe set <= if need to iterate back to beginning
			if(checker.Flag == ItemFlag.empty_since_start) {
				return null; //not found
			}else if(checker.Flag == ItemFlag.normal && checker.Key == key) {
				return checker;
			}else {
				count++;
				index++;
				if(index == this.Size) {
					index = 0;
				}
				checker = this.Table[index];
			}
		}
		return null; //not found
	}
	
	
	public void Remove(int key) {
		//same w search
		//mark flag to be empty-after-rm if you find the key
		Item remove = Search(key);
		if(remove != null) {
			remove.Flag = ItemFlag.empty_after_removal;
			System.out.println("Remove Successfully");
		}else {
			System.out.println("Item not found");
		}
	}
	
	public void Display(){
		int count = 0;
		int index = 0;
		Item printer = this.Table[index];
		while(count < this.Size) { //maybe set <= if need to iterate back to beginning
			if(printer.Flag == ItemFlag.empty_since_start) {
				System.out.println(printer.Key + " " + null); //not found
			}else if(printer.Flag == ItemFlag.normal) {
				//print key, value
				String key = Integer.toString(printer.Key);
				String value = printer.Value;
				System.out.println(key + " " + value);
			}else if(printer.Flag == ItemFlag.empty_after_removal) {
				System.out.println(printer.Key + " " + null); //not found
			}
			count ++;
			index ++;
			if(count < this.Size) {
				printer = this.Table[index];
			}
		}
	}
}
