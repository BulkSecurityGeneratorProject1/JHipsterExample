import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ITelephone } from 'app/shared/model/telephone.model';
import { AccountService } from 'app/core';
import { TelephoneService } from './telephone.service';

@Component({
    selector: 'jhi-telephone',
    templateUrl: './telephone.component.html'
})
export class TelephoneComponent implements OnInit, OnDestroy {
    telephones: ITelephone[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected telephoneService: TelephoneService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {}

    loadAll() {
        this.telephoneService
            .query()
            .pipe(
                filter((res: HttpResponse<ITelephone[]>) => res.ok),
                map((res: HttpResponse<ITelephone[]>) => res.body)
            )
            .subscribe(
                (res: ITelephone[]) => {
                    this.telephones = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInTelephones();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ITelephone) {
        return item.id;
    }

    registerChangeInTelephones() {
        this.eventSubscriber = this.eventManager.subscribe('telephoneListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
