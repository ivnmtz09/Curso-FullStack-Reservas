import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CreateReservationRequest, ReservationResponse } from '../model/reservation';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class ReservationService {
  private http = inject(HttpClient);
  private baseUrl = `${environment.baseUrl}/reservations`;

  getAllReservations(): Observable<ReservationResponse[]> {
    return this.http.get<ReservationResponse[]>(this.baseUrl);
  }

  createReservation(request: CreateReservationRequest): Observable<ReservationResponse> {
    return this.http.post<ReservationResponse>(this.baseUrl, request);
  }

  cancelReservation(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
