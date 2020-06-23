package com.Group1;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Jailer Class
 */
public class ManageJailer extends Personnel{
	/**
	 * This field will be used when we make operations.
	 * */
	protected DataBase dataBase; //we will use it when we make operations

	public ManageJailer(int id){
		super(id);
	}

	public ManageJailer(DataBase data) {
		super(-1);
		dataBase = data;
	}

	/**
	 *Get inmate information by id, id take from user
	 *If id is not avaliable,return null
	 *@return Inmate
	 */
	public void getLastCensus(){
		if (dataBase.getLastInmateCensus ()!=null)
			System.out.println (dataBase.getLastInmateCensus ());
		else
			System.out.println ("No Last Census");

	}
	public void addCensus(){
		int number = GetChoiceFromUser.getNumber ("Enter number of Inmate: ");
		dataBase.addInmateCensus (number, DateFormat.getInstance().format(new Date()));
		System.out.println ("Census info was Added with today's date.");
	}

	public void removeLastCensus(){
		dataBase.deleteLastCensus ();
	}
	/**
	 * Checks if the count of the prisoners checks with the system census information
	 * @param numberOfPrisoners counted prisoner number
	 * @return true if count checks with the system, false if otherwise
	 */
	public boolean checkCensus(int numberOfPrisoners, DataBase dataBase)
	{
        /*if(dataBase.prisoners.size() == numberOfPrisoners) return true;
        else return false;*/
		return false;
	}

	public void showMenu(Personnel jailer) {
		int k;
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("Welcome Jailer " + jailer.getName() + " " + jailer.getSurname());
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("What Do you want to do ?");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[0] Main Menu.");
		for (k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n" + "   ");
		System.out.println("[1] Check Last census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[2] Add new Census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[3] Delete Last Census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[4] Set Alert");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[5] Undo Alert");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[6] Get a prisoner");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[7] Get your shift our");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[8] Get your department");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
	}

	public void manage(Personnel jailer){

		int choose;
		do {
			showMenu(jailer);
			choose = GetChoiceFromUser.getSubChoice(8, "Answer: ");

			switch (choose) {
				case 1:
					getLastCensus();
					break;
				case 2:
					addCensus();
					break;
				case 3:
					removeLastCensus();
					break;
				case 4:
					dataBase.setAlert();
					break;
				case 5:
					dataBase.undoAlert();
					break;
				case 6:
					getPrison();
					break;
				case 7:
					getShiftOur();
					break;
				case 8:
					System.out.println("Department:" + this.place.toString());
					break;

				default:
					break;

			}
		}while (choose != 0);
	}


	public void getPrison(){
		int k;
		Scanner scan = new Scanner(System.in);
		for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
		System.out.println("Enter ID of the prison: ");
		int id = scan.nextInt();
		System.out.println(dataBase.getInmate(id).toString());
	}

	public void getShiftOur(){
		int k;
		Scanner scan = new Scanner(System.in);
		System.out.println("Shift hours:" );
		for ( k = 0; k < 45; k++) System.out.print("-");

		for (int i = 0; i < this.shift.workdays.size(); i++) {
			System.out.println(this.shift.workdays.get(i));
		}
	}


}

