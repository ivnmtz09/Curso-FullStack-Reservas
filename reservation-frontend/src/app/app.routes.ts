import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./component/home/home.component').then((m) => m.HomeComponent),
    pathMatch: 'full',
  },
  {
    path: 'list',
    loadComponent: () =>
      import('./component/reservation-list/reservation-list.component').then(
        (m) => m.ReservationListComponent,
      ),
  },
  {
    path: 'create',
    loadComponent: () =>
      import('./component/reservation-create/reservation-create.component').then(
        (m) => m.ReservationCreateComponent,
      ),
  },
  {
    path: '**',
    redirectTo: '',
  },
];
