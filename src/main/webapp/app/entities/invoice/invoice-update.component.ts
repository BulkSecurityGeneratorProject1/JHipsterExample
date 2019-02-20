import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IInvoice } from 'app/shared/model/invoice.model';
import { InvoiceService } from './invoice.service';
import { IClient } from 'app/shared/model/client.model';
import { ClientService } from 'app/entities/client';
import { IDiscount } from 'app/shared/model/discount.model';
import { DiscountService } from 'app/entities/discount';

@Component({
    selector: 'jhi-invoice-update',
    templateUrl: './invoice-update.component.html'
})
export class InvoiceUpdateComponent implements OnInit {
    invoice: IInvoice;
    isSaving: boolean;

    clients: IClient[];

    discounts: IDiscount[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected invoiceService: InvoiceService,
        protected clientService: ClientService,
        protected discountService: DiscountService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ invoice }) => {
            this.invoice = invoice;
        });
        this.clientService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IClient[]>) => mayBeOk.ok),
                map((response: HttpResponse<IClient[]>) => response.body)
            )
            .subscribe((res: IClient[]) => (this.clients = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.discountService
            .query({ filter: 'invoice-is-null' })
            .pipe(
                filter((mayBeOk: HttpResponse<IDiscount[]>) => mayBeOk.ok),
                map((response: HttpResponse<IDiscount[]>) => response.body)
            )
            .subscribe(
                (res: IDiscount[]) => {
                    if (!this.invoice.discountId) {
                        this.discounts = res;
                    } else {
                        this.discountService
                            .find(this.invoice.discountId)
                            .pipe(
                                filter((subResMayBeOk: HttpResponse<IDiscount>) => subResMayBeOk.ok),
                                map((subResponse: HttpResponse<IDiscount>) => subResponse.body)
                            )
                            .subscribe(
                                (subRes: IDiscount) => (this.discounts = [subRes].concat(res)),
                                (subRes: HttpErrorResponse) => this.onError(subRes.message)
                            );
                    }
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.invoice.id !== undefined) {
            this.subscribeToSaveResponse(this.invoiceService.update(this.invoice));
        } else {
            this.subscribeToSaveResponse(this.invoiceService.create(this.invoice));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IInvoice>>) {
        result.subscribe((res: HttpResponse<IInvoice>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackDiscountById(index: number, item: IDiscount) {
        return item.id;
    }
}
