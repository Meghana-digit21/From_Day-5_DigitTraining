
package lockscenario;

public class LivelockScenario {
    static class Resource {
        private boolean locked = false;
        public synchronized boolean isLocked() {
            return locked;
        }
        public synchronized void setLocked(boolean locked) {
            this.locked = locked;
        }
    }

    public static void main(String[] args) {
        final Resource resource1 = new Resource();
        final Resource resource2 = new Resource();

        Thread t1 = new Thread(() -> {
            while (true) {
                if (!resource1.isLocked()) {
                    System.out.println("Thread 1: Locked resource 1");
                    resource1.setLocked(true);
                    try { Thread.sleep(50); } catch (InterruptedException e) {}

                    if (resource2.isLocked()) {
                        System.out.println("Thread 1: Resource 2 is locked, unlocking resource 1");
                        resource1.setLocked(false);
                        continue;
                    }

                    System.out.println("Thread 1: Locked resource 2");
                    resource2.setLocked(true);
                    break;
                }
            }

            System.out.println("Thread 1: Doing work with both resources");
            resource1.setLocked(false);
            resource2.setLocked(false);
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (!resource2.isLocked()) {
                    System.out.println("Thread 2: Locked resource 2");
                    resource2.setLocked(true);
                    try { Thread.sleep(50); } catch (InterruptedException e) {}

                    if (resource1.isLocked()) {
                        System.out.println("Thread 2: Resource 1 is locked, unlocking resource 2");
                        resource2.setLocked(false);
                        continue;
                    }

                    System.out.println("Thread 2: Locked resource 1");
                    resource1.setLocked(true);
                    break;
                }
            }

            System.out.println("Thread 2: Doing work with both resources");
            resource2.setLocked(false);
            resource1.setLocked(false);
        });

        t1.start();
        t2.start();
    }
}
