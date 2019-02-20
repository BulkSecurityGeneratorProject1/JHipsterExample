import { NgModule } from '@angular/core';

import { EjemploSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [EjemploSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [EjemploSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class EjemploSharedCommonModule {}
