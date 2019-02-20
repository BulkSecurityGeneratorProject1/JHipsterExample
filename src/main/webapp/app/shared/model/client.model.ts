import { IAddress } from 'app/shared/model/address.model';
import { ITelephone } from 'app/shared/model/telephone.model';
import { IInvoice } from 'app/shared/model/invoice.model';

export interface IClient {
    id?: number;
    name?: string;
    addresses?: IAddress[];
    telephones?: ITelephone[];
    invoices?: IInvoice[];
}

export class Client implements IClient {
    constructor(
        public id?: number,
        public name?: string,
        public addresses?: IAddress[],
        public telephones?: ITelephone[],
        public invoices?: IInvoice[]
    ) {}
}
