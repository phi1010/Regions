class Point
    {
        Point(int x, int y)
        {
            _X = x;
            _Y = y;
        }

        int _X, _Y;

        public int GetX()
        {
            return _X;
        }

        public int GetY()
        {
            return _Y;
        }

    }