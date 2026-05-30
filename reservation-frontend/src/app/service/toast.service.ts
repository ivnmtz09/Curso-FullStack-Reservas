import { Injectable, signal } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class ToastService {
  private _message = signal<string | null>(null);
  message = this._message.asReadonly();

  show(msg: string, ms = 3500) {
    this._message.set(msg);
    setTimeout(() => this._message.set(null), ms);
  }

  clear() {
    this._message.set(null);
  }
}
