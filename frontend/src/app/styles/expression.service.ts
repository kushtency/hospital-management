import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExpressionService {
  apply: any = {
    navbar: "bg-gray-900 text-slate-100 w-full h-14 flex justify-between items-center py-5 px-14",
    button: "bg-emerald-800 py-1 px-2 rounded-md font-semibold text-md text-gray-200 btn",
    form_container: "position-relative rounded-xl bg-gray-100/80 p-14 drop-shadow-md w-1/2",
    form_input: "px-5 rounded-md w-56",
    form_div: "flex justify-between w-full flex-wrap",
    window: "flex justify-center items-center h-screen",
    h1: "text-6xl font-bold ",
    h2: "text-3xl font-bold",
    h3: "text-2xl font-regular",
    errorMsg: "text-red-600 font-regular text-sm",
  }
  constructor() { }
}
