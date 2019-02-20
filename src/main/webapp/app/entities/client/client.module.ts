import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { EjemploSharedModule } from 'app/shared';
import {
    ClientComponent,
    ClientDetailComponent,
    ClientUpdateComponent,
    ClientDeletePopupComponent,
    ClientDeleteDialogComponent,
    clientRoute,
    clientPopupRoute
} from './';

const ENTITY_STATES = [...clientRoute, ...clientPopupRoute];

@NgModule({
    imports: [EjemploSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [ClientComponent, ClientDetailComponent, ClientUpdateComponent, ClientDeleteDialogComponent, ClientDeletePopupComponent],
    entryComponents: [ClientComponent, ClientUpdateComponent, ClientDeleteDialogComponent, ClientDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class EjemploClientModule {}
