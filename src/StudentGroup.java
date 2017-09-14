package src;


import java.util.Arrays;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {

		return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		int len=students.length;
                for(int i=index;i<len+1;i++)
                {
                    students[i+1]=students[i];
                }
                students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		int len=students.length;
                for(int i=0;i<len+1;i++)
                {
                    students[i+1]=students[i];
                }
                students[0]=student;
	}

	@Override
	public void addLast(Student student) {
		int len=students.length;
                students[len]=student;
	}

	@Override
	public void add(Student student, int index) {
		int len=students.length;
                for(int i=index;i<len+1;i++)
                {
                    students[i+1]=students[i];
                }
                 students[index]=student;
	}

	@Override
	public void remove(int index) {
		int len=students.length;
                for(int i=index;i<len-1;i++)
                {
                    students[i]=students[i+1];
                }
	}

	@Override
	public void remove(Student student) {
		int len=students.length;
                int count=0;
                for(int i=0;i<len;i++)
                {
                    if(students[i]==student)
                    {
                        count=i;
                        students[i]=students[i+1];
                    }
                }
                for(int i=count;i<len-1;i++)
                {
                    students[i]=students[i+1];
                }
	}

	@Override
	public void removeFromIndex(int index) {
		int len=students.length;
                for(int i=index;i<len;i++)
                {
                   students[i+1]=null; 
                }
	}

	@Override
	public void removeFromElement(Student student) {
                int len=students.length;
                int count=0;
                for(int i=0;students[i]!=student;i++)
                {
                    count=i;
                }
                for(int i=count;i<len;i++)
                {
                    students[i+1]=null;
                }
        }

	@Override
	public void removeToIndex(int index) {
		int len=students.length;
                for(int i=0;i<index;i++)
                {
                    students[i]=null;
                }
	}

	@Override
	public void removeToElement(Student student) {
		int len=students.length;
                for(int i=0;students[i]!=student;i++)
                {
                    students[i]=null;
                }
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		int len=students.length;
                for(int i=0;i<len;i++)
                {
                    if(students[i].getBirthDate()==date)
                    {
                        System.out.println(students[i]);
                    }
                }
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		int len=students.length;
                Student[] arr=null;
                for(int i=0;i<len;i++)
                {
                    if((students[i].getBirthDate().after(firstDate)) && (students[i].getBirthDate().before(lastDate)))
                    {
                        arr[i]=students[i];
                    }
                }
		return arr;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		int len=students.length;
                Student[] narr=null;
                double arr[]=new double[len];
                for(int i=0;i<len;i++)
                {
                    arr[i]=students[i].getAvgMark();
                }
                Arrays.sort(arr);
                int j=0;
                for(int i=0;i<len;i++)
                {
                    if(arr[len]==students[i].getAvgMark())
                    {
                        narr[j]=students[i];
                    }
                }
		return narr;
	}

	@Override
	public Student getNextStudent(Student student) {
		int len=students.length;
                int count=0;
                for(int i=0;students[i]!=student;i++)
                {
                    count=i;
                }
                return students[count+1];
	}
}
