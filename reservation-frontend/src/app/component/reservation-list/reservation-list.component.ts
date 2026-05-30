import { Component, ChangeDetectionStrategy, signal, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReservationService } from '../../service/reservation.service';
import { RouterModule } from '@angular/router';
import { ReservationResponse } from '../../model/reservation';

@Component({
  selector: 'app-reservation-list',
  imports: [CommonModule, RouterModule],
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ReservationListComponent implements OnInit {
  private reservationService = inject(ReservationService);

  reservations = signal<ReservationResponse[]>([]);
  loading = signal(false);
  cancellingIds = signal<number[]>([]);

  ngOnInit(): void {
    this.load();
  }

  private load() {
    this.loading.set(true);
    this.reservationService.getAllReservations().subscribe({
      next: (list) => {
        this.reservations.set(list || []);
        this.loading.set(false);
      },
      error: () => this.loading.set(false),
    });
  }

  isCancelling(id: number) {
    return this.cancellingIds().includes(id);
  }

  cancel(id: number) {
    if (!confirm('¿Confirmas cancelar la reserva?')) return;
    // mark as cancelling
    this.cancellingIds.set([...this.cancellingIds(), id]);
    this.reservationService.cancelReservation(id).subscribe({
      next: () => {
        this.reservations.set(this.reservations().filter((r) => r.id !== id));
        this.cancellingIds.set(this.cancellingIds().filter((i) => i !== id));
      },
      error: () => {
        // remove cancelling flag on error
        this.cancellingIds.set(this.cancellingIds().filter((i) => i !== id));
      },
    });
  }
}
