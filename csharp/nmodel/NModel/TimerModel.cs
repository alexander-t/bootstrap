using NModel;
using NModel.Attributes;
using NModel.Execution;

namespace ModelTest
{
    enum State { Start, Reset, SettingTime, CountingDown, CountingUp };
    
    public static class TimerModel
    {
        static State state = State.Start;

        [Action]
        static void PressMin_Sec() 
        {
            state = State.Reset;
        }
        static bool PressMin_SecEnabled()
        {
            return true; // Resetting is always possible
        }

        [Action]
        static void PressMin()
        {
            state = State.SettingTime;
        }
        static bool PressMinEnabled()
        {
            return state == State.Reset || state == State.SettingTime; 
        }

        [Action]
        static void PressSec()
        {
            state = State.SettingTime;
        }
        static bool PressSecEnabled()
        {
            return state == State.Reset || state == State.SettingTime;
        }

        [Action]
        static void PressStartStop()
        {
            if (state == State.CountingDown)
            {
                state = State.SettingTime;
            }
            else if (state == State.Reset)
            {
                state = State.CountingUp;
            }
            else
            {
                state = State.CountingDown;
            }
        }
        static bool PressStartStopEnabled()
        {
            return state == State.SettingTime || state == State.Reset || state == State.CountingDown;
        }

        public static ModelProgram Create() 
        { 
            return LibraryModelProgram.Create(typeof(TimerModel)); 
        }
    }
}