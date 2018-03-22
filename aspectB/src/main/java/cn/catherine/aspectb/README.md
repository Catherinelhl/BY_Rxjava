http://blog.csdn.net/eclipsexys/article/details/54425414



####this is a library to test AspectJ

there are Kotlin & Java programmer

AspectJ之Join Points
Join Points，简称JPoints，是AspectJ的核心思想之一，它就像一把刀，把程序的整个执行过程切成了一段段不同的部分。
例如，构造方法调用、调用方法、方法执行、异常等等，这些都是Join Points，实际上，也就是你想把新的代码插在程序的哪个地方，
是插在构造方法中，还是插在某个方法调用前，或者是插在某个方法中，这个地方就是Join Points，当然，不是所有地方都能给你插的，
只有能插的地方，才叫Join Points。

AspectJ之Pointcuts
Join Points和Pointcuts的区别实际上很难说，我也不敢说我理解的一定对，但这些都是概念上的内容，并不影响我们去使用。
Aspect rules:

@Before：Advice，也就是具体的插入点
execution：处理Join Point的类型，例如call、execution
(* android.app.Activity.on**(..))：这个是最重要的表达式，第一个『*』表示返回值，
『*』表示返回值为任意类型，后面这个就是典型的包名路径，其中可以包含『*』来进行通配，
几个『*』没区别。同时，这里可以通过『&&、||、!』来进行条件组合。()代表这个方法的参数，
你可以指定类型，例如android.os.Bundle，或者(..)这样来代表任意类型、任意个数的参数。
public void onActivityMethodBefore：实际切入的代码。
