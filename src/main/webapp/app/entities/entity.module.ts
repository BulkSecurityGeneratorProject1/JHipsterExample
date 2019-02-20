import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'client',
                loadChildren: './client/client.module#EjemploClientModule'
            },
            {
                path: 'address',
                loadChildren: './address/address.module#EjemploAddressModule'
            },
            {
                path: 'telephone',
                loadChildren: './telephone/telephone.module#EjemploTelephoneModule'
            },
            {
                path: 'invoice',
                loadChildren: './invoice/invoice.module#EjemploInvoiceModule'
            },
            {
                path: 'discount',
                loadChildren: './discount/discount.module#EjemploDiscountModule'
            }
            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EjemploEntityModule {}
