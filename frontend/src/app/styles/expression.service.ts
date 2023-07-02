import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExpressionService {
  apply: any = {
    navbar: "bg-gray-900 text-slate-100 w-full h-14 flex justify-between items-center py-5 px-14",
    button: "bg-emerald-800 py-1 px-2 rounded-md font-semibold text-md text-gray-200 btn",
    form_container: "flex justify-center items-start flex-col gap-5 w-1/2 rounded-xl bg-gray-100  p-14 drop-shadow-md",
    form_input: "px-5 rounded-md w-56",
    form_div: "flex justify-between w-full flex-wrap",
    window: "flex justify-center items-center h-screen w-screen",
  }
  constructor() { }
}
