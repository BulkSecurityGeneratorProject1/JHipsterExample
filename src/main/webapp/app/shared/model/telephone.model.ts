export interface ITelephone {
    id?: number;
    number?: number;
    clientId?: number;
}

export class Telephone implements ITelephone {
    constructor(public id?: number, public number?: number, public clientId?: number) {}
}
