import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExpressionService {
  apply: any = {
    navbar: "bg-gray-900 text-slate-100 w-full h-14 flex justify-between items-center py-5 px-14 sticky top-0",
    button: "bg-emerald-800 py-1 px-2 rounded-md font-semibold text-md btn",
  }
  constructor() { }
}
