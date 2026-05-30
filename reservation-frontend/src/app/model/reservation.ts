export interface CreateReservationRequest {
  customerName: string;
  date: string;
  time: string;
  service: string;
}

export enum ReservationStatus {
  Active = 'ACTIVE',
  CANCELLED = 'CANCELLED',
}

export interface ReservationResponse {
  id: number;
  customerName: string;
  date: string;
  time: string;
  service: string;
}
