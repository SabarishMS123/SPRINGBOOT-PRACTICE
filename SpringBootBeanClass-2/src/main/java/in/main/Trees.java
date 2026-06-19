package in.main;

public class Trees {
    private String botanicalname;
    private String localname;
    private int tid;
	public String getBotanicalname() {
		return botanicalname;
	}
	public void setBotanicalname(String botanicalname) {
		this.botanicalname = botanicalname;
	}
	public String getLocalname() {
		return localname;
	}
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public Trees(String botanicalname, String localname, int tid) {
		super();
		this.botanicalname = botanicalname;
		this.localname = localname;
		this.tid = tid;
	}
   public void displayTrees()
   {
	   System.out.println("Tree ID :" + tid);
	   System.out.println("Tree's Botanical Name :" + botanicalname);
	   System.out.println("Tree's local Name :"+ localname);
   }
    
}
