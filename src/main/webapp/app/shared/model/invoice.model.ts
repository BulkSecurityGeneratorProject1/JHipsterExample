export interface IInvoice {
    id?: number;
    itemCount?: number;
    subTotal?: number;
    clientId?: number;
    discountId?: number;
}

export class Invoice implements IInvoice {
    constructor(
        public id?: number,
        public itemCount?: number,
        public subTotal?: number,
        public clientId?: number,
        public discountId?: number
    ) {}
}
