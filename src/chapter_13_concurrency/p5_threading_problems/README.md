
# Identifying Threading Problems

Liveness problems are often the result of a thread entering a BLOCKING or WAITING state forever, or repeatedly entering/exiting these states. There are three types of liveness issues with you should be familiar

- Deadlock: Occurs when two or more threads are blocked forever, each waiting on the other.
- Starvation: Occurs when a single thread is perpetually denied access to a shared resource or lock.
- Livelock: Occurs when two or more threads are conceptually blocked forever, although they are each still active and trying to complete their task.
