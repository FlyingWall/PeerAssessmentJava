
public class BasicCalc {
	String mainID;
	String[] studentID;
	String[] comments;
	float mainMark;
	float[] studentMark;
	int studentCount;
	float[] peerMarks;
	float finalMark = 0;
	boolean countSelfMarks;
	String errors="";
	
	public BasicCalc(){
		mainID = "";
		studentID = new String[0]; 
		mainMark = 0;
		studentMark = new float[0];
		studentCount = 0;
		peerMarks = new float[0];
		countSelfMarks = true;
	}
	
	public BasicCalc(int student) {
		this.studentCount = student;
		studentID = new String[studentCount]; 
		comments = new String[studentCount];
		studentMark = new float[studentCount];
		peerMarks = new float[studentCount];
		countSelfMarks = true;
	}
	
	public BasicCalc(int student, String[] ID, float[] marks, String com[], boolean countMarks) {
		int n = 0;
		float totalMarks=0;
		this.studentCount = student;
		studentID = new String[studentCount]; 
		studentMark = new float[studentCount];
		peerMarks = new float[studentCount];
		countSelfMarks = countMarks;
		for(int i=0;i<student;i++) {
			studentID[i] = ID[i];
			studentMark[i] = marks[i];
			totalMarks+=totalMarks;
			if(studentID[i]== mainID) {
				n++;
				mainMark = studentMark[i];
			}
		}
		if(totalMarks != 100) {
			addError("Total Marks do not reach 100%");
		}
		if(n>1) {
			addError("Multiple user ID's");
		}else if(n==0){
			addError("No Marked ID matches submitted ID");
		}
	}
	
	public String getID() {
		return mainID;
	}
	
	public float getSelfMark() {
		return mainMark;
	}
	
	public float getFinalMark() {
		return finalMark;
	}
	
	public void trueSelfMarks() {
		countSelfMarks = true;
	}
	
	public void flaseSelfMarks() {
		countSelfMarks = false;
	}
	
	public void addError(String err) {
		errors = errors + "Error: " + err + ";  ";
	}
	
	public void Calc() {
		
		for(int i=0;i<studentCount;i++) {
			finalMark += peerMarks[i];
		}
		if(countSelfMarks) {
			finalMark /= studentCount;
		}else {
			finalMark -= mainMark;
			finalMark /= (studentCount - 1);
		}
	}
}
