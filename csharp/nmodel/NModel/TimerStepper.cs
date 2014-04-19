using NModel.Conformance;
using NModel.Terms;
using System;


namespace ModelTest
{
    /* This doesn't really test anything. It just prints the individual actions
     * as the model is being traversed. However, this class does show how to
     * implement a stepper.
     */ 
    public class TimerStepper : IStepper
    {

        public CompoundTerm DoAction(CompoundTerm compoundTerm)
        {
            Console.Out.Write("Press ");
            switch (compoundTerm.Name)
            { 
                case "PressMin_Sec":
                    Console.Out.WriteLine("Both Min and Sec");
                    return null;
                case "PressMin":
                    Console.Out.WriteLine("Min");
                    return null;
                case "PressSec":
                    Console.Out.WriteLine("Sec");
                    return null;
                case "PressStartStop":
                    Console.Out.WriteLine("Start/Stop");
                    return null;
            }
            Console.Out.WriteLine("DoAction(" + compoundTerm.Name + ")");
            return null;
        }

        public void Reset() {
            Console.Out.WriteLine("--- RESET ---");
        }

        public static IStepper Create() 
        {
            return new TimerStepper();
        }
    }
}
