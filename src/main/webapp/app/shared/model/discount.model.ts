export interface IDiscount {
    id?: number;
    value?: number;
}

export class Discount implements IDiscount {
    constructor(public id?: number, public value?: number) {}
}
