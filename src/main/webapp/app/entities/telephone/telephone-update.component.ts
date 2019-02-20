import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { ITelephone } from 'app/shared/model/telephone.model';
import { TelephoneService } from './telephone.service';
import { IClient } from 'app/shared/model/client.model';
import { ClientService } from 'app/entities/client';

@Component({
    selector: 'jhi-telephone-update',
    templateUrl: './telephone-update.component.html'
})
export class TelephoneUpdateComponent implements OnInit {
    telephone: ITelephone;
    isSaving: boolean;

    clients: IClient[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected telephoneService: TelephoneService,
        protected clientService: ClientService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ telephone }) => {
            this.telephone = telephone;
        });
        this.clientService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IClient[]>) => mayBeOk.ok),
                map((response: HttpResponse<IClient[]>) => response.body)
            )
            .subscribe((res: IClient[]) => (this.clients = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.telephone.id !== undefined) {
            this.subscribeToSaveResponse(this.telephoneService.update(this.telephone));
        } else {
            this.subscribeToSaveResponse(this.telephoneService.create(this.telephone));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ITelephone>>) {
        result.subscribe((res: HttpResponse<ITelephone>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackClientById(index: number, item: IClient) {
        return item.id;
    }
}
