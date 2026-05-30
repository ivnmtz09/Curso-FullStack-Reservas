import { Component, ChangeDetectionStrategy, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { ReservationService } from '../../service/reservation.service';
import { ToastService } from '../../service/toast.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-reservation-create',
  templateUrl: './reservation-create.component.html',
  styleUrls: ['./reservation-create.component.css'],
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ReservationCreateComponent {
  private fb = inject(FormBuilder);
  private reservationService = inject(ReservationService);
  private toast = inject(ToastService);
  private router = inject(Router);

  services = ['Haircut', 'Massage', 'Manicure', 'Consultation'];

  form = this.fb.group({
    nombreCliente: ['', Validators.required],
    fecha: ['', Validators.required],
    hora: ['', Validators.required],
    servicio: ['', Validators.required],
  });

  submitting = false;

  submit() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.submitting = true;
    const val = this.form.value as any;
    const req = {
      customerName: val.nombreCliente,
      date: val.fecha,
      time: val.hora,
      service: val.servicio,
    };

    this.reservationService.createReservation(req).subscribe({
      next: () => {
        this.submitting = false;
        this.toast.show('Reserva creada correctamente');
        this.router.navigateByUrl('/');
      },
      error: (err) => {
        this.submitting = false;
        const message = err?.error?.message || 'Error al crear la reserva';
        this.toast.show(message);
      },
    });
  }
}
