package UILayer;

import ControlLayer.LoanControl;

import java.util.ArrayList;

import static UILayer.MenuText.*;


/**
 * Created by Admin on 12/7/2016.
 */
public class LoanMenu {
    public int menu() {
        LoanControl loanControl = new LoanControl();
        int choice;

        do {
            MenuText.write(LOAN_MENU);
            choice = Input.readInt();

            switch (choice) {
                case 1: //create
                    if (loanControl.addLoan(InputChecker.verifySaleNumberID(), InputChecker.verifyQuantity(), InputChecker.verifyPrice(), InputChecker.verifyId(), InputChecker.verifyDate(), InputChecker.verifyPeriod())) {
                        MenuText.write(SUCCESS);
                    }
                    else {
                        MenuText.write(FAILURE);
                    }
                    break;
                case 2: //read
                    ArrayList<String> loans = loanControl.readLoan(InputChecker.verifySaleNumberID());
                    if (loans != null) {
                        System.out.println(loans);
                    }
                    else {
                        MenuText.write(FAILURE);
                    }
                    break;
                case 3: // update
                    String numberID = InputChecker.verifySaleNumberID();
                    ArrayList<String> loans2 = loanControl.readLoan(numberID);
                    if (loans2 != null) {
                        System.out.println(loans2);
                    }
                    else {
                        MenuText.write(FAILURE);
                        break;
                    }
                    int fieldNumber = InputChecker.verifyFieldNumber(loans2.size());
                    Object fieldInfo = checkData(fieldNumber);
                    if (loanControl.updateLoan(numberID, fieldNumber, fieldInfo)) {
                        MenuText.write(SUCCESS);
                    }
                case 4:
                    //go back
                    break;
                case 5:
                    //exit code
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 5.");
            }
        }
        while (choice != 4 && choice != 5);
        if (choice == 5) {
            return 7;
        }
        else {
            return 1;
        }
    }

    public Object checkData(int fieldNumber)
    {
        switch (fieldNumber)
        {
            case 1:
                return InputChecker.verifySaleNumberID();
            case 2:
                return InputChecker.verifyQuantity();
            case 3:
                return InputChecker.verifyPrice();
            case 4:
                return InputChecker.verifyId();
            case 5:
                return InputChecker.verifyDate();
            case 6:
                return InputChecker.verifyPeriod();
            default:
                return null;
        }
    }
}