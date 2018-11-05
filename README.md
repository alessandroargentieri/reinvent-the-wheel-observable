# reinvent-the-wheel-observable
A little reimplementation of an Observable

The interesting part is that just method accepts a Supplier and not directly the Object we want to observe reactively.
The body of supplier is elaborated only after the call to subscribe method.

If you set breakpoints in the for cycle within MainApplication you can see that it is called after subscribe call.

Besides of that, this simple implementation of Observable uses map method to transform your Observable object to another, just adding a new function which will transform the future object.
In this specific implementation, map method resume both map and flatMap methods of Observable implemented by the famous RxJava.

The subscribe method has two implementation: one for the success, the other for both success and possible Exceptions.
The subscribe method accepts these two callbacks methods (which are the single methods of the two anonymous implementations of the Consumer functional interfaces) which allows the reactive reaction after the lazy executions.
