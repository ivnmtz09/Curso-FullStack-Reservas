import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ToastComponent } from './component/toast/toast.component';

@Component({
  standalone: true,
  selector: 'app-root',
  imports: [RouterOutlet, ToastComponent],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
})
export class App {
  protected readonly title = signal('reservation-frontend');
}
