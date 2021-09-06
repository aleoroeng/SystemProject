export class User {

    constructor(firstName: string, lastName: string, contactNumber: number, emailId: string, address: string, businessJustification: string, status: string, date: Date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.address = address;
        this.businessJustification = businessJustification;
        this.status = status;
        this.date = date;
    }

    public firstName: string;
    public lastName: string;
    public contactNumber: number;
    public emailId: string;
    public address: string;
    public businessJustification: string;
    public status: string;
    public date: Date;
}