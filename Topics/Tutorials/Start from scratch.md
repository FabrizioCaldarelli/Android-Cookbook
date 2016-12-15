# Start from scratch

**1. Folders structure:**

All Android apps should have these packages
```
- activities
- classes
- fragments
- models
- views
```

**2. Extend every classes from a Base class:**

For each above packages, create also an inner 'base' package where put:

```
- activities/base/BaseActivity
- fragments/base/BaseFragment
- models/base/BaseModel
- views/base/BaseView
```

and you'll extend every new classes from these base class
