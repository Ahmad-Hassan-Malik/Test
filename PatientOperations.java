public class PatientOperations {

    int front;
    int rear;
    int size;
    Patient[] patients;

    public PatientOperations(int capacity) {
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        patients = new Patient[capacity];
    }

    public void addPatient(String type, String id) {
        Patient newPatient = new Patient(type, id);

        if (size == patients.length) {
            System.out.println("No place for new Patients...!!!");
            return;
        }

        if (rear == -1 && front == -1) {
            front = 0;
            rear = 0;
            patients[rear] = newPatient;
            size++;
            System.out.println("Patient added...");
        } else if (newPatient.type.equals("critical")) {
            for (int i = front; i <= rear; i++) {
                if (patients[i].type.equals("non-critical")) {
                    for (int j = rear; j >= i; j--) {
                        patients[(j+1) % patients.length] = patients[j];
                    }
                    patients[i] = newPatient;
                    System.out.println("Patient added...");
                    rear = (rear + 1) % patients.length;
                    size++;
                    return;
                }
            }
        } else {
            rear = (rear + 1) % patients.length;
            System.out.println("Patient added...");
            patients[rear] = newPatient;
            size++;
        }
    }


    public void treatPatient() {
        if (size == 0) {
            System.out.println("No Patients to treat...!!!");
            return;
        }

        if (front == rear) {
            System.out.println("Patient " + patients[front].id + " trated successfully...!!!");
            front = -1;
            rear = -1;
            size--;
        } else {
            System.out.println("Patient " + patients[front].id + " trated successfully...!!!");
            front = (front + 1)  % patients.length;
            size--;
        }
    }


    public void addInEmergency(String id) {
        if (size == 0) {
            System.out.println("No Patients...");
            return;
        } else {
           // int i = front;
           for (int i = front; i <= rear; i++) {
               if (patients[i].id.equals(id) && patients[i].type.equals("non-critical")) {
                   if (patients[front].id.equals(patients[i].id)) {
                       System.out.println("The Patient is already in Emergency...!!!");
                   } else {
                       Patient emergencyPatient = patients[i];
                       for (int j = i; j <= rear; j++) {
                           patients[j] = patients[j+1];
                       }
                       rear = (rear - 1) % patients.length;

                       for (int k = rear; k >= front; k--) {
                           patients[k+1] = patients[k];
                       }
                       patients[front] = emergencyPatient;
                       rear = (rear + 1) % patients.length;
                   }
               } else {
                   System.out.println("The Patient is already in critical Situation...!!!");
               }
               return;
           }
        }
    }



    public void showPatients() {
        if (front == -1 || rear == -1) {
            System.out.println("No Patients...!!!");
            return;
        }
        int i = front;
        while (true) {
            System.out.println(patients[i].toString());

            if (i == rear) break;
            i = (i + 1) % patients.length;
        }
    }


    public void addInEmergency2(String id) {
        if (size == 0) {
            System.out.println("No Patients...");
        } else {
             int i = front;
            while (true) {
                if (patients[i].id.equals(id) && patients[i].type.equals("non-critical")) {
                    if (patients[front].id.equals(patients[i].id)) {
                        System.out.println("The Patient is already in Emergency...!!!");
                    } else {
                        Patient emergencyPatient = patients[i];
                        int j = i;
                        while (true) {
                            patients[j] = patients[(j+1)% patients.length];
                            if (j == rear) break;
                            j = (j + 1) % patients.length;
                        }
                        rear = (rear - 1) % patients.length;

                        int k = rear;
                        while (true) {
                            patients[(k+1) % patients.length] = patients[k];
                            if (k == front) break;
                            if (k == 0) {
                                k = patients.length - 1;
                            } else {
                                k = (k - 1) % patients.length;
                            }
                        }
                        patients[front] = emergencyPatient;
                        rear = (rear + 1) % patients.length;

                        System.out.println("Patient " + id + " is added in emergency...!!!");
                    }
                }
                    if (i == rear) break;
                    i = (i + 1) % patients.length;
            }
        }
    }
}
