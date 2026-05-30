import { Component, ChangeDetectionStrategy, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastService } from '../../service/toast.service';

@Component({
  selector: 'app-toast',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './toast.component.html',
  styleUrls: ['./toast.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ToastComponent {
  private toast = inject(ToastService);
  message = this.toast.message;
}
